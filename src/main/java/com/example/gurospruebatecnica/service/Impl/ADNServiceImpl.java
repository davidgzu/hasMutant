package com.example.gurospruebatecnica.service.Impl;

import com.example.gurospruebatecnica.DTO.AdnDTO;
import com.example.gurospruebatecnica.service.ADNService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ADNServiceImpl implements ADNService {

  private char[][] Matrix;

  @Override
  public boolean hasMutation(AdnDTO dna) {
    fillMatrix(dna);
    int matrixLenght = Matrix.length;
    printMatriz(Matrix, matrixLenght);

    boolean horizontal = horizontalSearch(Matrix, matrixLenght);
    if (horizontal) return horizontal;

    boolean vertical = verticalSearch(Matrix, matrixLenght);
    if(vertical) return vertical;

    boolean diagonal = diagonalSearch(Matrix);
    if(diagonal) return diagonal;

    boolean reverseDiagonal = reverseDiagonalSearch(Matrix, matrixLenght);
    if(reverseDiagonal) return reverseDiagonal;

    return false;
  }

  public void fillMatrix(AdnDTO dna){
    String[] data = dna.getDna().toArray(new String[0]);
    Matrix = new char[data.length][data.length];
    for (int i = 0; i < data.length; i++ ){
      this.setArrayMatrix(data[i].toCharArray(), i);
    }
  }

  public void printMatriz (char[][] arr, int largoMatriz){
    for (int i = 0; i < largoMatriz; i++) {
      for (int j = 0; j < largoMatriz; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }

  public void setArrayMatrix(char[] array, int posicion) {
    this.Matrix[posicion] = array;
  }

  public boolean horizontalSearch(char[][] array, int matrixLength){

    for (int i = 0; i < matrixLength; i++){
      for (int j = 0; j <= 2 ; j++){
          if(array[i][j] == array [i][j+ 1] &&
            array[i][j] == array[i][j + 2] &&
            array[i][j] == array[i][j + 3]){
              return true;
            }
          }
        }
    return false;
  }

  public boolean verticalSearch(char[][] array, int matrixLenght){

    for (int i = 0; i <= 2; i++){
      for (int j = 0; j < matrixLenght; j++){
          if (array[i][j] == array[i+1][j] &&
            array[i][j] == array[i+2][j] &&
            array[i][j] == array[i+3][j]
          ) {
            return true;
          }
        }
      }
    return false;
  }

  public boolean diagonalSearch(char[][]array){
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
          if (array[i][j] == array[i+1][j+1] &&
            array[i][j] == array[i+2][j+2] &&
            array[i][j] == array[i+3][j+3]
          ){
            return true;
          }
        }
      }

    return false;
  }

  public boolean reverseDiagonalSearch(char[][]array, int matrixLenght){
    for (int i = 0; i <= 2  ; i++){
      for (int j = matrixLenght-1; j >= 3 ; j--){
        if(array[i][j] == array[i+1][j-1] &&
          array[i][j] == array[i+2][j-2] &&
          array[i][j] == array[i+3][j-3]
        ) {
          return true;
        }
      }
    }
    return false;
  }
}
