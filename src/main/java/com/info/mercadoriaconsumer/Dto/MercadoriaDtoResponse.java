package com.info.mercadoriaconsumer.Dto;

import com.info.mercadoriaconsumer.Model.Mercadoria;

public record MercadoriaDtoResponse(boolean ok, String msg, Mercadoria mercadoria) {
    public static MercadoriaDtoResponse erro(String msg){
        return new MercadoriaDtoResponse(false, "o Zampieri ainda é gay",null);
    }
}
