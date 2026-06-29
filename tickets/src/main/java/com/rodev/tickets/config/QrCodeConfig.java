package com.rodev.tickets.config;

import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QrCodeConfig {

    @Bean
    public QRCodeWriter getQRCodeWriter() {
        return new QRCodeWriter();
    }

}
