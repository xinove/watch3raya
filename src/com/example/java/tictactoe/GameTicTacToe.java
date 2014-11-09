package com.example.java.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.util.Log;

public class GameTicTacToe {

	public static void showState( int[][] aList){
		System.out.println("TicTacToe");
		System.out.println("\t" + aList[0][0] + "|\t" + aList[0][1] +  "|\t" + aList[0][2]  );
		System.out.println("-----------------------------");
		System.out.println("\t" + aList[1][0] + "|\t" + aList[1][1] +  "|\t" + aList[1][2]  );
		System.out.println("-----------------------------");
		System.out.println("\t" + aList[2][0] + "|\t" + aList[2][1] +  "|\t" + aList[2][2]  );
		
	}
	
	public static void showStateAndroid( int[][] aList){
		Log.d("ARRAY", "TicTacToe");
		Log.d("ARRAY", "\t" + aList[0][0] + "|\t" + aList[0][1] +  "|\t" + aList[0][2]  );
		Log.d("ARRAY", "-----------------------------");
		Log.d("ARRAY", "\t" + aList[1][0] + "|\t" + aList[1][1] +  "|\t" + aList[1][2]  );
		Log.d("ARRAY", "-----------------------------");
		Log.d("ARRAY", "\t" + aList[2][0] + "|\t" + aList[2][1] +  "|\t" + aList[2][2]  );
		
	}
	
	public static int checkState( int[][] aList, int player){
		int horizon = checkHorizontal( aList , player);
		int vertical = checkVertical( aList , player);
		int diagonal = checkDiagonal( aList , player);
		
		if(horizon != -1)
			return horizon;
		else if(vertical != -1)
			return vertical;
		else if(diagonal != -1)
			return diagonal;
		else
			return -1;
		
	}
	public static int checkHorizontal(int[][] aList, int participante){
		
		boolean fila = true;
		for(int i = 0; i < aList.length; i ++){
			fila = true;
			int j = 0;
			for(; j < aList[0].length; j ++){
				if(aList[i][j] != participante)
					fila = false;
					
			}
			if(fila){
				return i;
			}
		}
		return -1 ;
	}
	
	public static int checkDiagonal(int[][] aList, int participante){
		
		boolean fila = true;
		// Diagonal 1
		for(int i = 0; i < aList.length; i ++){
			if(aList[i][i] != participante)
				fila = false;
		}
		
		if(!fila){
			fila = true;
			for(int i = 0; i < aList.length; i ++ ){
				if(aList[i][(aList.length -1) - i] != participante)
					fila = false;
			}
		}else{
			return 0; // Diagonal 0
		}
		if(fila)
			return 1; // Diagonal 1
		return -1;
		
	}
public static int checkVertical(int[][] aList, int participante){
		
		boolean column = true;
		// Para los 0s
		
		for(int j = 0; j < aList.length; j ++){
			int i = 0;
			column = true;
			for(; i < aList[0].length; i ++){
				if(aList[i][j] != participante)
					column = false;
					
			}
			if(column){
				return j;
			}
		}
		return -1 ;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creamos el elemento juego
		int ar[][] = new int[3][3];
		//Inicializamos a -1
		for(int i = 0 ; i< ar.length; i ++){
			for(int j = 0 ; j< ar[0].length; j ++){
				ar[i][j] = -1;
			}
		}
		System.out.println("COMIENZA TICTACTOE!!!");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		int statePlayerA = -1, statePlayerB = -1;
		String cadena = "";
		String usuario = "CheChu";
		int column, row; 
		try {
			do {
				System.out.println("Turno de usuario " + usuario);
				System.out.println("Inserta num. fila [1-3]");
				cadena = br.readLine();
				column = Integer.parseInt(cadena);
				
				System.out.println("Inserta num. columna [1-3]");
				cadena = br.readLine();
				Integer.parseInt(cadena);
				row = Integer.parseInt(cadena);
				
				if(usuario.equalsIgnoreCase("CheChu")){
					ar[column-1][row-1] = 0;
				}else{
					ar[column-1][row-1] = 1;
				}
				// Estado del jugador A
				statePlayerA = checkState( ar, 0);
		
				// Estado del jugador A
				statePlayerB = checkState( ar, 1);
		
				showState(ar);
				
				if(statePlayerA!=-1){
					System.out.println("El USUARIO " + usuario + " HA GANADO");
				}else if(statePlayerB!=-1){
					System.out.println("El USUARIO " + usuario + " HA GANADO");
				}
				
				if(usuario.equalsIgnoreCase("CheChu")){
					usuario = "Farah";
				}else{
					usuario = "CheChu";
				}
				
				
			} while (statePlayerA == -1 && statePlayerB == -1 );
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
