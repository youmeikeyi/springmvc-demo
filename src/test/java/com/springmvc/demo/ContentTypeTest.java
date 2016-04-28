package com.springmvc.demo;

import com.springmvc.controller.support.converter.StringToPhoneNumberConverter;
import com.springmvc.controller.support.formatter.PhoneNumberFormatAnnotationFormatterFactory;
import com.springmvc.demo.model.FormatterModel;
import com.springmvc.demo.model.PhoneNumberModel;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.number.CurrencyFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by xujinchao on 2016/4/8.
 */
public class ContentTypeTest {


    private static void jsonRequest() throws IOException, URISyntaxException {
//请求的地址
        String url = "http://localhost:9080/springmvc-chapter6/response/ContentType";
//①创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request =
                new SimpleClientHttpRequestFactory().
                        createRequest(new URI(url), HttpMethod.POST);
//②设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().set("Accept", "application/json");
//③发送请求并得到响应
        ClientHttpResponse response = request.execute();
//④得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
//⑤得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int) response.getHeaders().getContentLength()];
        is.read(bytes);
        String jsonData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", json data : " + jsonData);
    }

    private static void xmlRequest() throws IOException, URISyntaxException {
//请求的地址
        String url = "http://localhost:9080/springmvc-chapter6/response/ContentType";
//①创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request =
                new SimpleClientHttpRequestFactory().
                        createRequest(new URI(url), HttpMethod.POST);
//②设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().set("Accept", "application/xml");
//③发送请求并得到响应
        ClientHttpResponse response = request.execute();
//④得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
//⑤得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int) response.getHeaders().getContentLength()];
        is.read(bytes);
        String xmlData = new String(bytes, charset);
        System.out.println("charset : " + charset + ", xml data : " + xmlData);
    }

    @Test
    public void testStringToPhoneNumberConvert() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToPhoneNumberConverter());
        String phoneNumberStr = "010-12345678";
        PhoneNumberModel phoneNumber = conversionService.convert(phoneNumberStr, PhoneNumberModel.class);
        Assert.assertEquals("010", phoneNumber.getAreaCode());
    }

    @Test
    public void testOtherConvert() {
        DefaultConversionService conversionService = new DefaultConversionService();
//"1"--->true（字符串“1”可以转换为布尔值true）
        Assert.assertEquals(Boolean.valueOf(true), conversionService.convert("1", Boolean.class));
//"1,2,3,4"--->List（转换完毕的集合大小为4）
        Assert.assertEquals(4, conversionService.convert("1,2,3,4", List.class).size());
    }

    @Test
    public void testWithDefaultFormattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//默认不自动注册任何Formatter
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        currencyFormatter.setFractionDigits(2);//保留小数点后几位
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);//舍入模式（ceilling表示四舍五入
//注册Formatter SPI实现

        conversionService.addFormatter(currencyFormatter);
//绑定Locale信息到ThreadLocal
//FormattingConversionService内部自动获取作为Locale信息，如果不设值默认是 Locale.getDefault()
        LocaleContextHolder.setLocale(Locale.US);
        Assert.assertEquals("$1,234.13", conversionService.convert(new BigDecimal("1234.128"), String.class));
        LocaleContextHolder.setLocale(null);
        LocaleContextHolder.setLocale(Locale.CHINA);
        Assert.assertEquals("￥1,234.13", conversionService.convert(new BigDecimal("1234.128"), String.class));
        Assert.assertEquals(new BigDecimal("1234.13"), conversionService.convert("￥1,234.13", BigDecimal.class));
        LocaleContextHolder.setLocale(null);
    }


    @Test
    public void test() throws SecurityException, NoSuchFieldException {
//默认自动注册对@NumberFormat和@DateTimeFormat的支持
        DefaultFormattingConversionService conversionService =
                new DefaultFormattingConversionService();
//准备测试模型对象
        FormatterModel model = new FormatterModel();
        model.setTotalCount(10000);
        model.setDiscount(0.51);
        model.setSumMoney(10000.13);
        model.setRegisterDate(new Date(2012 - 1900, 4, 1));
        model.setOrderDate(new Date(2012 - 1900, 4, 1, 20, 18, 18));
//获取类型信息
        TypeDescriptor descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("totalCount"));
        TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);
        Assert.assertEquals("10,000", conversionService.convert(model.getTotalCount(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getTotalCount(), conversionService.convert("10,000", stringDescriptor, descriptor));

        descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("registerDate"));
        Assert.assertEquals("2012-05-01", conversionService.convert(model.getRegisterDate(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getRegisterDate(), conversionService.convert("2012-05-01", stringDescriptor,
                descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("orderDate"))));
        Assert.assertEquals("2012-05-01 20:18:18", conversionService.convert(model.getOrderDate(), descriptor, stringDescriptor));
        Assert.assertEquals(model.getOrderDate(), conversionService.convert("2012-05-01 20:18:18", stringDescriptor));

        //添加自定义注解 格式化工厂
        conversionService.addFormatterForFieldAnnotation(new PhoneNumberFormatAnnotationFormatterFactory());
        model = new FormatterModel();
        TypeDescriptor descriptor1 = new TypeDescriptor(FormatterModel.class.getDeclaredField("phoneNumber"));
//        PhoneNumberModel value = conversionService.convert("010-12349809", conversionService.convert(model
//                .getPhoneNumber(), stringDescriptor));
//        model.setPhoneNumber(value);
    }
}
