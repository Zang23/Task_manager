package view;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kc = new KillController();
		
		//Processos em Windows
		
		//kc.listaProc("TASKLIST /FO TABLE");
		//kc.mataPid(23988);
		//kc.mataNome("notepad.exe");
		
		//Processos em Linux
		//kc.listaProc("ps -ef");
		//kc.mataPid(6411);
		//kc.mataNome("mousepad");
	}
	

}
