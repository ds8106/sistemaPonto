package com.ponto.modulo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;


public class BoletoPontoDataService {

    public String registroEntrada() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public String registroSaida() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        return simpleDateFormat.format(date);

    }

    public double bancoDeHoras(String regEntrada, String regSaida) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHoraEntrada = LocalDateTime.parse(regEntrada, dateTimeFormatter);
        LocalDateTime dataHoraSaida = LocalDateTime.parse(regSaida, dateTimeFormatter);

        return ChronoUnit.HOURS.between(dataHoraEntrada, dataHoraSaida);

    }
}