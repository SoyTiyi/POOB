import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int cantidad = 0;
        if(personas.size()==0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        else{
            for(Persona p: personas){
                try{
                    cantidad+=p.valorHora();
                }
                catch(EquipoExcepcion e){
                    cantidad+=0;
                }
            }
        }
        return cantidad;
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es la
     * media de los valores conocidos
     * Más del 75% del equipo debe tener valores conocidos 
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o si no es posible calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int denominador = valorPromedio();
        int valorEstimado = valorHora()/denominador;
        System.out.println(valorEstimado);
        int cantidad=0;
        if(personas.size()==0){throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);}
        else{
            for(Persona p: personas){
                try{
                    cantidad+=p.valorHora();
                }
                catch(EquipoExcepcion e){
                    cantidad+=valorEstimado;
                }
            }
        }
        return cantidad;
    }
    
    private int valorPromedio(){
        int n=0;
        for(Persona p:personas){
            try{
                p.valorHora();
            }
            catch(EquipoExcepcion e){
                n+=1;
            }
        }
        return n;
    }
}
