package model;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Archivio {
    private ArrayList<Automobile> automobili;
    private ArrayList<Cliente> proprietari;


    public Archivio() {
    }

    public Archivio(ArrayList<Automobile> automobili, ArrayList<Cliente> proprietari) {
        this.automobili = automobili;
        this.proprietari = proprietari;
    }

    public ArrayList<Automobile> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(ArrayList<Automobile> automobili) {
        this.automobili = automobili;
    }

    public ArrayList<Cliente> getProprietari() {
        return proprietari;
    }

    public void setProprietari(ArrayList<Cliente> proprietari) {
        this.proprietari = proprietari;
    }

    private int indiceCliente(String cf) throws AssicurazioneException {
        int result = -1;
        if (cf == null) {
            throw new AssicurazioneException("il parametro è null");
        } else {
            for (int i = 0; i < proprietari.size(); i++) {
                if (proprietari.get(i).getCf().equals(cf)) {
                    result = i;
                }
            }
        }
        return result;
    }

    private int indiceTarga(String unaTarga) throws AssicurazioneException {
        int result = -1;
        if (unaTarga == null) {
            throw new AssicurazioneException(" parametro è null");
        } else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getTarga().equals(unaTarga)) {
                    result = i;
                }
            }
        }
        return result;
    }

    public void addCliente(String cf) throws AssicurazioneException {
        if (cf == null)
            throw new AssicurazioneException("il cf è null");
        else {
            int result = indiceCliente(cf);
            if (result == -1) {
                Cliente e = new Cliente(cf);
                proprietari.add(e);
            }
        }
    }

    public void addMobile(String unaTarga, String cf) throws AssicurazioneException {
        if (unaTarga == null || cf == null)
            throw new AssicurazioneException("il cf è null");
        else {
            int result = indiceTarga(unaTarga);
            if (result == -1) {
                Automobile e = new Automobile(unaTarga, new Cliente(cf));
                automobili.add(e);
            }
        }
    }

    public ArrayList returnTarga(String cf) throws AssicurazioneException {
        ArrayList<String> targhe = new ArrayList<>();
        if (cf == null)
            throw new AssicurazioneException("il cf è null");
        else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getProprietario().getCf().equals(cf)) {
                    targhe.add(automobili.get(i).getTarga());
                }
            }
        }
        return targhe;
    }
    public String clienteTarga(String unaTarga)throws AssicurazioneException{
        String a = null;
        if (unaTarga == null)
            throw new AssicurazioneException("il ya pas la targa");
        else {

            for (Automobile c : automobili) {
                if (c.getTarga().equals(unaTarga)) {
                    a = c.getProprietario().getCf();
                }
            }
        }
        return a;
    }

}/// fine










