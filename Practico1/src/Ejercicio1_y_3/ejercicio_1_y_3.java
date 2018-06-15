package Ejercicio1_y_3;

public class ejercicio_1_y_3 {

	public static void main(String[] args) {
		String texto = "aaa eee t,tt te vfdc g:df www(222) dfkg?df";
		String [] palabras = texto.split("[ :.,()?¿!¡]");
		int palabrasProcesar = palabras.length;
		int i=0;
		for(i=0; i<palabrasProcesar; i++) {
			if(palabras[i].length()>1) {
				System.out.print(palabras[i].substring(0, 1) + "-");
			}
				
			
		}
		System.out.println("\n------------");
		i = 0;
		for(i=0; i<palabrasProcesar; i++) {
			palabras[i] = palabras[i].replaceAll(" ", "");
			if(palabras[i].length()>1) {
				System.out.print(palabras[i].substring(0, 1) + "-");
			} else if(palabras[i].length()==0) {
				System.out.print("cero");
			}
			
		}
		
		/* 
		Pattern patron = Pattern.compile("^ ");
		Matcher encaja = patron.matcher("aa.a.eee t,tt te vfdc g:df dfkg(fdk) dfkg?df");
		String resultado = encaja.replaceAll(" - ");
		System.out.println(resultado);
		
		
		String texto = "aaa.eee.t,tt te vfdc g:df dfkg(fdk) dfkg?df";
		Pattern p = Pattern.compile("^.|^@");
	    Matcher m = p.matcher(texto);
	    if (m.find()) {
	    	System.out.println(m.toString());
	    }
	      
	    
	    Pattern p = Pattern.compile("(\\\\.[\\\\w-]+)*");
        Matcher m = p.matcher("aaa.eee.t,tt te vfdc g:df dfkg(fdk) dfkg?df");
        int i = 1;
        while (m.find()) {
            System.out.println("grupo A: " + m.group(i++));
            
        }
        */
        
        
        
        
        
        
	}

}
