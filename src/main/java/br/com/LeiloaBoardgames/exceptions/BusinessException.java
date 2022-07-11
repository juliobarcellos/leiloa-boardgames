package br.com.LeiloaBoardgames.exceptions;

import java.util.function.Supplier;

public class BusinessException extends RuntimeException{
    public BusinessException(String s) {
        super(s);
    }
}
