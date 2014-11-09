package com.example.tictactoe;

import com.example.java.tictactoe.GameTicTacToe;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;



public class MainActivity extends Activity implements OnTouchListener {
	
	TextView txt;
	TextView txt2;
	ImageView im1;
	ImageView im2;
	ImageView im3;
	ImageView im4;
	ImageView im5;
	ImageView im6;
	ImageView im7;
	ImageView im8;
	ImageView im9;
	
	LinearLayout l1;
	LinearLayout l2;
	LinearLayout l3;
	LinearLayout l4;
	LinearLayout l5;
	LinearLayout l6;
	LinearLayout l7;
	LinearLayout l8;
	LinearLayout l9;
	
	LinearLayout tablero;
	
	GameTicTacToe gTicTacToe;
	int[][] aList;
	public MainActivity(){
		
		//Inicializamos a -1
		aList = new int[3][3];
		for(int i = 0 ; i< aList.length; i ++){
			for(int j = 0 ; j< aList[0].length; j ++){
				aList[i][j] = -1;
			}
		}
		gTicTacToe = new GameTicTacToe();
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
         
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
         
        
        tablero = (LinearLayout)findViewById(R.id.tablero);
        tablero.getLayoutParams().height = tablero.getWidth();
        tablero.requestLayout();
        
        
        txt2 = (TextView)findViewById(R.id.textView1);
        txt2.setOnTouchListener(this);
        
        int dips = 200;
        float pixelBoton = 0;
        float scaleDensity = 0;
        //Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        switch(metrics.densityDpi)
        {
        case DisplayMetrics.DENSITY_HIGH: //HDPI
            txt2.setText("Alta Densidad");
            scaleDensity = scale * 240;
            pixelBoton = dips * (scaleDensity / 240);
            break;
        case DisplayMetrics.DENSITY_MEDIUM: //MDPI
        	txt2.setText("mediana Densidad");
            scaleDensity = scale * 160;
            pixelBoton = dips * (scaleDensity / 160);
            break;
             
        case DisplayMetrics.DENSITY_LOW:  //LDPI
        	txt2.setText("baja Densidad");
            scaleDensity = scale * 120;
            pixelBoton = dips * (scaleDensity / 120);
            break;
        }
        Log.d(getClass().getSimpleName(), "pixels:"+Float.toString(pixelBoton));
         
        
        txt = (TextView)findViewById(R.id.textView1);
        txt.setOnTouchListener(this);
        
        im1 = (ImageView)findViewById(R.id.imageView1);
        im2 = (ImageView)findViewById(R.id.imageView2);
        im3 = (ImageView)findViewById(R.id.imageView3);
        im4 = (ImageView)findViewById(R.id.imageView4);
        im5 = (ImageView)findViewById(R.id.imageView5);
        im6 = (ImageView)findViewById(R.id.imageView6);
        im7 = (ImageView)findViewById(R.id.imageView7);
        im8 = (ImageView)findViewById(R.id.imageView8);
        im9 = (ImageView)findViewById(R.id.imageView9);
        
        l1 = (LinearLayout)findViewById(R.id.c1);
        l2 = (LinearLayout)findViewById(R.id.c2);
        l3 = (LinearLayout)findViewById(R.id.c3);
        l4 = (LinearLayout)findViewById(R.id.c4);
        l5 = (LinearLayout)findViewById(R.id.c5);
        l6 = (LinearLayout)findViewById(R.id.c6);
        l7 = (LinearLayout)findViewById(R.id.c7);
        l8 = (LinearLayout)findViewById(R.id.c8);
        l9 = (LinearLayout)findViewById(R.id.c9);
        
        l1.setOnTouchListener(this);
        l2.setOnTouchListener(this);
        l3.setOnTouchListener(this);
        l4.setOnTouchListener(this);
        l5.setOnTouchListener(this);
        l6.setOnTouchListener(this);
        l7.setOnTouchListener(this);
        l8.setOnTouchListener(this);
        l9.setOnTouchListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

    	int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
   public boolean onTouch (View v, MotionEvent event) {
    	Log.d("PAco: ", "MEnsajeee");
       
        if (v == txt){
        	Log.d("Chechu", "Valor a mostrar: " + v.getId());
    		
    		Log.d("Chechu", "Evento del toque x: " + event.getX());
    		Log.d("Chechu", "Evento del toque y: " + event.getY());
    		
    		Log.d("Chechu", "Evento del toque x: " + v.getX());
    		Log.d("Chechu", "Evento del toque y: " + v.getY());
    		
    		txt.setText("Has activado un evento touch");
        }
        
        if( v == l1){
        	if (im1.getVisibility() != 0 ){
        		Log.d("Leches", "Visibles: "+ im1.getVisibility());
        		if (getNumVisibles()){
        			aList[0][0] = 0;
        			im1.setImageResource(R.drawable.o);
        		}else{
        			aList[0][0] = 1;
        			im1.setImageResource(R.drawable.x);
        		}
        		im1.setVisibility(1);
        	}
        }
        if( v == l2){
        	Log.d("Leches", "Imagen2: "+ im2.getVisibility());
        	if (im2.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im2.setImageResource(R.drawable.o);
        			aList[0][1] = 0;
        		}else{
        			im2.setImageResource(R.drawable.x);
        			aList[0][1] = 1;
        		}
        		im2.setVisibility(1);
        	}
        }
        if( v == l3){
        	Log.d("Leches", "Imagen3: "+ im3.getVisibility());
        	if (im3.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im3.setImageResource(R.drawable.o);
        			aList[0][2] = 0;
        		}else{
        			aList[0][2] = 1;
        			im3.setImageResource(R.drawable.x);
        		}
        		im3.setVisibility(1);
        	}
        }
        if( v == l4){
        	if (im4.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im4.setImageResource(R.drawable.o);
        			aList[1][0] = 0;
        		}else{
        			im4.setImageResource(R.drawable.x);
        			aList[1][0] = 1;
        		}
        		im4.setVisibility(1);
        	}
        }
        if( v == l5){
        	if (im5.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im5.setImageResource(R.drawable.o);
        			aList[1][1] = 0;
        		}else{
        			im5.setImageResource(R.drawable.x);
        			aList[1][1] = 1;
        		}
        		im5.setVisibility(1);
        	}
        }
        if( v == l6){
        	Log.d("Leches", "Imagen6: "+ im6.getVisibility());
        	if (im6.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im6.setImageResource(R.drawable.o);
        			aList[1][2] = 0;
        		}else{
        			im6.setImageResource(R.drawable.x);
        			aList[1][2] = 1;
        		}
        		im6.setVisibility(1);
        	}
        }
        if( v == l7){
        	Log.d("Leches", "Imagen7: "+ im7.getVisibility());
        	if (im7.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im7.setImageResource(R.drawable.o);
        			aList[2][0] = 0;
        		}else{
        			im7.setImageResource(R.drawable.x);
        			aList[2][0] = 1;
        		}
        		im7.setVisibility(1);
        	}
        }
        if( v == l8){
        	Log.d("Leches", "Imagen8: "+ im8.getVisibility());
        	if (im8.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im8.setImageResource(R.drawable.o);
        			aList[2][1] = 0;
        		}else{
        			im8.setImageResource(R.drawable.x);
        			aList[2][1] = 1;
        		}
        		im8.setVisibility(1);
        	}
        }
        if( v == l9){
        	if (im9.getVisibility() != 0 ){
        		if (getNumVisibles()){
        			im9.setImageResource(R.drawable.o);
        			aList[2][2] = 0;
        		}else{
        			im9.setImageResource(R.drawable.x);
        			aList[2][2] = 1;
        		}im9.setVisibility(1);
        	}
        }
        
        // Estado del jugador A
		int statePlayerA = gTicTacToe.checkState( aList, 0);

		// Estado del jugador A
		int statePlayerB = gTicTacToe.checkState( aList, 1);
		
		gTicTacToe.showStateAndroid(aList);
		
		Log.d("JUEGO", "JugadorA: "+ statePlayerA);
		Log.d("JUEGO", "JugadorB: "+ statePlayerB);
		
		if(statePlayerA != -1 || statePlayerB != -1){
			Context context = getApplicationContext();
			Toast toast;
			
			if (statePlayerA != -1){
				toast = Toast.makeText(context, "JugadorA HA GANADO! CIRCULOS", 10);
				txt.setText("JugadorA HA GANADO! CIRCULOS");
				Log.d("GANADOR", "JugadorA HA GANADO! CIRCULOS");
				toast.show();
			}else if (statePlayerB != -1 ){
				toast = Toast.makeText(context, "JugadorB HA GANADO! EQUIS! ", 10);
				txt.setText("JugadorB HA GANADO! EQUIS! ");
				Log.d("GANADOR", "JugadorB HA GANADO! EQUIS! ");
				toast.show();
			}
			inicializarJuego();
		}
		return true;
    }
    
    public boolean getNumVisibles(){
    	int count = 0 ;
    	
    	if (im1.getVisibility() != 0) count++;
    	if (im2.getVisibility() != 0) count++;
    	if (im3.getVisibility() != 0) count++;
    	if (im4.getVisibility() != 0) count++;
    	if (im5.getVisibility() != 0) count++;
    	if (im6.getVisibility() != 0) count++;
    	if (im7.getVisibility() != 0) count++;
    	if (im8.getVisibility() != 0) count++;
    	if (im9.getVisibility() != 0) count++;
    	
    	return count%2==0;
    }
	/*@Override
	public boolean onTouch(View v, MotionEvent event) {
		Log.d("Chechu", "Valor a mostrar: " + v.getId());
		
		Log.d("Chechu", "Evento del toque x: " + event.getX());
		Log.d("Chechu", "Evento del toque y: " + event.getY());
		
		Log.d("Chechu", "Evento del toque x: " + v.getX());
		Log.d("Chechu", "Evento del toque y: " + v.getY());
		
		txt.setText("Has activado un evento touch");
		return true;
	} */
    
    private void inicializarJuego(){
		//Inicializamos a -1
		aList = new int[3][3];
		for(int i = 0 ; i< aList.length; i ++){
			for(int j = 0 ; j< aList[0].length; j ++){
				aList[i][j] = -1;
			}
		}
		gTicTacToe = new GameTicTacToe();
		
		//quitar imagenes
		im1.setVisibility(0);
		im2.setVisibility(0);
		im3.setVisibility(0);
		im4.setVisibility(0);
		im5.setVisibility(0);
		im6.setVisibility(0);
		im7.setVisibility(0);
		im8.setVisibility(0);
		im9.setVisibility(0);
		
    }
}
