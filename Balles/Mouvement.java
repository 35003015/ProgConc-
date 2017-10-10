public class Mouvement extends Thread{
    public Balles panneau;
    public int x,y;
    public boolean on = false;
    public Mouvement(Balles panneau){
        this.panneau = panneau;
        this.setDaemon(true);

    }
    public void run(){
        try{
            while(true){
                if(on){
                    for(Balle b:panneau.liste){
                        x = b.getPosX();
                        y = b.getPosY();
                        if(x < 0) {  b.backX = false; }
                        if(x > panneau.getWidth() - 45) { b.backX = true; }
                        if(y < 0) { b.backY = false; }
                        if(y > panneau.getHeight() - 45) { b.backY = true; }
                        if(!(b.backX)) { b.setPosX(++x); }
                        else { b.setPosX(--x); }
                        if(!(b.backY)) { b.setPosY(++y); }
                        else { b.setPosY(--y); }

                    }
                }

                sleep(10);
            }
        } catch (InterruptedException e) { }
    }
}
