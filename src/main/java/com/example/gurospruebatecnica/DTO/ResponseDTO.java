package com.example.gurospruebatecnica.DTO;

public class ResponseDTO<T> {
  private T content;

  public ResponseDTO(T content) {
    this.content = content;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }
}
