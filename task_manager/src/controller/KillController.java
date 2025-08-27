package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProc(String proc) {
		
		String os = os();
		String[] vetProc = proc.split(" ");
		
		if(os.contains("Windows")){
			leSaida(vetProc);
		}else if(os.contains("Linux")) {
			leSaida(vetProc);
		}
		
	}
	
	private void leSaida(String[] vetProc) {
		try {
			Process p = Runtime.getRuntime().exec(vetProc);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void mataPid(int pid) {
		String os = os();
		
		if(os.contains("Windows")) {
			try {
				executaComando("TASKKILL /PID " + pid);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else if(os.contains("Linux")) {
			try {
				executaComando("kill -9 " + pid);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
	public void mataNome(String nomeProc) {
		String os = os();
		
		if(os.contains("Windows")) {
			try {
				executaComando("TASKKILL /IM " + nomeProc);	
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}else if(os.contains("Linux")) {
			try {
				executaComando("pkill -f " + nomeProc);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private void executaComando(String comando) throws IOException {
		String[] vetComando = comando.split(" ");
		Runtime.getRuntime().exec(vetComando);
	}
	

		
		
	
	
	
}