package br.com.mystream.mystream.service.interfaces;

public interface IConvertData {
    <T> T getData(String json, Class<T> tClass);
}
