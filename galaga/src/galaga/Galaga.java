package galaga;

public class Galaga {

	private Nave nave;
    private Enemigo[] enemigos;
    private Disparo[] disparos;
    private int puntuacion;
    
    
    public Galaga() {
        super();
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(this);

        nave = new Nave(375, 550);
        enemigos = new Enemigo[10];
        for (int i = 0; i < enemigos.length; i++) {
            enemigos[i] = new Enemigo((i + 1) * 70, 100);
        }
        disparos = new Disparo[10];
        puntuacion = 0;
    }
    
    private void disparar() {
        for (int i = 0; i < disparos.length; i++) {
            if (disparos[i] == null) {
                disparos[i] = new Disparo(nave.getX() + nave.getAncho() / 2, nave.getY());
                break;
            }
        }
    }
    
}
