package aplicacion;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Sinap contiene la informacion del Sistema Nacional de Areas Protegidas
 * @author POOB 01 
 * @version ECI 
 */

public class Sinap{
    private final LinkedList<Area> areas;

    /**
     * Inicia un kiosko vacio
     */
    public Sinap() {
        areas = new LinkedList<Area>();
    }
    /**
     * Adicione Tuparro
     */
    public void adicioneTuparro() throws SINAPExcepcion{
        adicione("Tuparro National Park","","Vichada","548.000",
        "Es una extensa sabana verde surcada por grandees ríos con potentes raudales y playas doradas, pequeños"
                +"caños de aguas cristalinas, bosques de galeria, morichales y saladillales, ademas de enormes rocas"
                +"cristalinas en forma de cerros redondeados.");
    }
    /**
     * Adiciona cinco areas
     */
    public void adicioneCinco() {
        final Area ejemplos[] = { new Area("Ciénaga Grande de Santa Marta", "Large Marsh of Saint Martha", "Madalena",
                "4280",
                "Santuario de flora y fauna."
                        + " Propender por la recuperación del modelo hidráulico del complejo lagunar CGSM en el área del Santuario,"
                        + " con el fin de garantizar el estado de conservación de la biodiversidad de flora y fauna y la productividad pesquera,"
                        + " para mantener los flujos de nutrientes y cumplir con los protocolos internacionales de Reserva de Biosfera y "
                        + " humedal Ramsar."),
                new Area("Nevado del Huila", "Nevado del Huila", " Huila, Tolima, Cauca", "1.580 km²", "Parque natural"
                        + " Es considerada estratégica ya que abastece las dos cuencas mas importantes del país "
                        + "(Cuenca alta del Río Magdalena y Cuenca alta del Río Cauca) catalogándola como una estrella hídrica "
                        + "del macizo colombiano, que aporta bienes y servicios ambientales representados en ecosistemas de Páramo,"
                        + "subparamo, bosque Andino y altoandino, favoreciendo asi la viabilidad de especies de flora y fauna."),
                new Area("Laguna de Sonso", "Laguna de Sonso", "Valle del Cauca", " 14,1 km²", "Reserva natural,"
                        + "Aves migratorias que durante el invierno viajan desde Norteamérica en busca de buen clima "
                        + "y turistas de todo el mundo encuentran en la Reserva Natural Laguna de Sonso, 10 km al suroccidente de Buga, "
                        + "un sitio apacible moldeado por el río Cauca que cuenta con una torre de observación de 10 m de altura."),
                new Area("Morichales de Paz de Ariporo", "Morichales de Paz de Ariporo", "Casanare", "",
                        "Propuesta de parque natural"
                                + " El ecosistema lo integra un humedal de 25 mil hectáreas donde impera la variedad de palma de moriche "
                                + "que sirve de refugio a buena parte de la fauna llanera y donde igualmente residen unas 200 familias que por décadas "
                                + "han habitado este paradisíaco lugar."),
                new Area("Parque Isla de Salamanca", "Salamanca Island Road Park", "Magalena", " 	562 km²",
                        "Vía parque'."
                                + "Posee 98 especies de invertebrados, 9 especies de anfibios, 35 especies de reptiles, más de 140 especies de peces, "
                                + "199 de aves, muchas de ellas migratorias, endémicas y residentes. La existencia de 33 especies de mamíferos indica "
                                + "que la diversidad que sostiene el área es elevada, a pesar de la problemática ambiental que afectó el ecosistema. "
                                + "El Vía Parque Isla de Salamanca cuenta con hábitats o refugios en donde se pueden observar especies declaradas en "
                                + "peligro de extinción por presión del hombre, destrucción y fragmentación de hábitats y disminución de la oferta "
                                + "alimentaria, entre otros factores."),
                new Area("Sistema Lacustre de Chingaza","gingham lake system","Meta","766 km²","Es un conjunto de lagunas y páramos,")};
        for (final Area detalles : ejemplos) {
            adicioneDetalles(detalles);
        }
    }

    /**
     * Consulta los detalles de una area
     * 
     * @param nombre El nombre de la area a buscar
     * @param name   El nombre internacional de la area a buscar
     * @return Los detalles correspondientes a ese nombre
     */
    public Area getDetalles(final String nombre, final String name) {
        Area c = null;
        for (int i = 0; i < areas.size() && c == null; i++) {
            if (areas.get(i).getNombre().compareToIgnoreCase(nombre) == 0
                    && (areas.get(i).getName().compareToIgnoreCase(name) == 0)) {
                c = areas.get(i);
            }
        }
        return c;
    }

    /**
     * Adiciona una nueva Area a la Kiosco
     * 
     * @param nombre
     * @param name
     * @param area
     * @param ubicacion
     * @param descripcion
     */
    public void adicione(final String nombre, final String name, final String ubicacion, final String area,
        final String descripcion) throws SINAPExcepcion{  
        final Area holi = new Area(nombre,name,ubicacion,area,descripcion);
        if(estaEnArea(holi)!=true) {
            if(holi.getName().equals("")){
                throw new SINAPExcepcion(SINAPExcepcion.NO_INTERNATIONAL_NAME);
            }
            else{     
                adicioneDetalles(new Area(nombre, name, ubicacion, area, descripcion));
            }
        }
        else{
            throw new SINAPExcepcion(SINAPExcepcion.AREA_REPETIDA);
        }
    }

    /**
     * Este metodo nos permitira saber si ya esta un area
     */
    public boolean estaEnArea(final Area newArea){
        boolean flag=false;
        for(int i=0;i<areas.size();i++){
            if(newArea.toString().equals(areas.get(i).toString())){
                flag=true;
            }   
        }
        return flag;
    }

    /**
     * Adiciona una nueva area al SINAP
     * 
     * @param detalles El detalle asociado con la area
     */
    public void adicioneDetalles(final Area detalles) {
        int i = 0;
        while ((i < areas.size()) && (areas.get(i).getNombre().compareToIgnoreCase(detalles.getNombre()) < 0)) {
            i++;
        }
        areas.add(i, detalles);
    }

    /**
     * Consulta las areas que inican con un prefijo
     * 
     * @param prefijo El prefijo a buscar
     * @return Los detalles encontrados
     */
    public ArrayList<Area> busque(String prefijo) {
        /**
         * Se cambio final ArrayList<Area>=null; a lo de abajo
         */
        final ArrayList<Area> resultados = new ArrayList<Area>();
        prefijo = prefijo.toUpperCase();
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getNombre().toUpperCase().startsWith(prefijo)) {
                resultados.add(areas.get(i));
            }
        }
        return resultados;
    }

    /**
     * Consulta el numero de areas
     * 
     * @return Numero de areas
     */
    public int numeroAreas() {
        return areas.size();
    }

    /**
     * Consulta todas las areas
     * 
     * @return Todas las areas
     */
    public String toString() {
        final StringBuffer allEntries = new StringBuffer();
        for (final Area detalles : areas) {
            allEntries.append(detalles.toString().length()<=150? detalles:detalles.toString().substring(0,149)+"...");
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}
