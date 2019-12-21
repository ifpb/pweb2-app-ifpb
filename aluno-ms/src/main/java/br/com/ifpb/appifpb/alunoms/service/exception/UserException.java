package br.com.ifpb.appifpb.alunoms.service.exception;

import java.util.function.Supplier;

public class UserException extends Exception {
    public UserException(String msg) {
        super(msg);
    }
}
