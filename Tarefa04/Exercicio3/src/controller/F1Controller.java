package controller;

import java.util.concurrent.Semaphore;

public class F1Controller extends Thread {
	
	// Variáveis de controle de carros e equipes
	static int currentTeam = -1;
	static int currentCar = -1;
	static int maxTeams = 7;
	static int maxCarByTeam = 2;
	static int maxLaps = 3;
	
	// Matriz que registra os tempos de cada um dos carros das equipes
	static boolean teams[][] = new boolean[maxTeams][maxCarByTeam];
	static int carLapTime[][][] = new int[maxTeams][maxCarByTeam][maxLaps];
	
	// Instanciando semaforos de controle
	static Semaphore smpTrack = new Semaphore(5);
	static Semaphore smpCar = new Semaphore(1);
	
	public F1Controller() {
		super();
		this.start();
	}
	
	@Override
	public void run() {
		try {
			smpTrack.acquire();
			//joinTrack(getCurrentTeam(), getCurrentCar());
			
			
			try {
				smpCar.acquire();
				joinTrack(getNextTeam(), getNextCar());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				smpCar.release();
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smpTrack.release();
			
		}
	}
	
	private void joinTrack(int carTeam, int carNumber) {
		teams[carTeam][carNumber] = true;
		currentTeam = carTeam;
		
		// Zerando a equipe caso os todos os carros já tenham percorrido
		if (teams[carTeam][maxCarByTeam-1]) {
			for (int i = 0; i < maxCarByTeam; i++) {
				teams[carTeam][i] = false;
			}
		}
		
		int lap[] = new int[maxLaps];
		
		for (int i = 0; i < maxLaps; i++) {
			lap[i] = (int) ((Math.random() * 11) + 20); // 20-30s
			System.out.println("O carro " + (carNumber+1) + " da equipe " + (carTeam+1) + " completou a " + (i+1) + "o. volta com " + lap[i] + "s;");
			// System.out.println(carTeam + " " + carNumber) ;
			
			carLapTime[carTeam][carNumber][i] = lap[i];
		}
	}
	
	/*
	// Retorna o a equipe a escolhida para entrar na pista
	public int getCurrentTeam() {
		if (currentTeam < (maxTeams-1) ) {
			currentTeam++;
		} else {
			currentTeam = 0;
		}
		
		return currentTeam;
	}
	
	// Retorna qual carro da equipe deve entrar na pista
	public int getCurrentCar() {
		if (currentCar < (maxCarByTeam-1)) {
			currentCar++;
		} else {
			currentCar = 0;
		}
		
		return currentCar;
	}
	*/
	
	public int getNextTeam() {
		for (int i = 0; i < maxTeams; i++) {
			if (teams[i][0]) {
				return i;
			}
		}
		return currentTeam+1;
	}
	
	public int getNextCar() {
		for (int i = 0; i < maxCarByTeam; i++) {
			if (teams[getNextTeam()][i]) {
				return i+1;
			}
		}
		return 0;
	}
	
}
