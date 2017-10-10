from threading import Thread, Condition
from time import *
import random
import tkinter as TK



class File:
    def __init__(self):
        self.liste = []
        self.cond = Condition()
        self.premier = 0
        self.dernier = 0


    def affichage(self):
        ch = "File = <"
        for e in self.liste:
            ch += str(e)
            ch += ", "
        ch += ">"
        text0.config(text=ch)

    def ajoute(self):
        with self.cond:
            while(len(self.liste) == 20):
                self.cond.wait()
            self.dernier = random.randint(1,100)
            self.liste.append(self.dernier)
            self.cond.notifyAll()


    def retrait(self):
        with self.cond:
            while(len(self.liste) == 0):
                self.cond.wait()
            self.premier = self.liste[0]
            del self.liste[0]
            self.cond.notifyAll()



class Producteur(Thread):
    def __init__(self, temps, liste):
        Thread.__init__(self)
        self.temps = temps
        self.liste = liste
        self.daemon = True
    def run(self):

        global text1
        while(True):
            self.liste.ajoute()
            self.liste.affichage()
            text1.config(text = "Producteur : Ajout de "+str(self.liste.dernier)+" effectue !")
            sleep(self.temps)



class Consommateur(Thread):
    def __init__(self, temps, liste, label):
        Thread.__init__(self)
        self.temps = temps
        self.liste = liste
        self.daemon = True
        self.label = label

    def run(self):
        while(True):

            self.liste.retrait()
            self.liste.affichage()
            self.label.config(text = "Consommateur : Retrait de "+str(self.liste.premier)+" effectue !")
            sleep(self.temps)

def lance_thread():
    f = File()
    p = Producteur(.5, f)
    c = Consommateur(2, f, text2)
    c1 = Consommateur(1,f, text3)
    p.start()
    c.start()
    c1.start()



if __name__ == "__main__":


    fenetre = TK.Tk()
    fenetre.geometry("500x200+300+0")
    # fenetre.configure(width=700, height=700)
    fenetre.resizable(width=False, height=False)
    bouton = TK.Button(fenetre, text="Start", command=lance_thread)
    text0 = TK.Label(fenetre, text="File = <>")
    text1 = TK.Label(fenetre, text="rien")
    text2 = TK.Label(fenetre, text="rien")
    text3 = TK.Label(fenetre, text="rien")
    text0.pack()
    text1.pack()
    text2.pack()
    text3.pack()
    bouton.pack(side="bottom")


    fenetre.mainloop()
