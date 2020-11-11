package com.example.p6recycleview;

import java.util.ArrayList;
import java.util.List;

public class AvionRepositorio {

    List<Avion> aviones= new ArrayList<>();

     interface Callback {
         void cuandoFinalice(List<Avion> aviones);
     }

     void AvionesRepositorio(){
         aviones.add(new Avion("Airbus A380", "El Airbus A380 es un avión tetrarreactor fabricado por la empresa europea Airbus, subsidiaria del grupo Airbus Group. Se trata de la primera aeronave de reacción con dos cubiertas a lo largo de todo su fuselaje."));
         aviones.add(new Avion("Boeing 747","El Boeing 747, comúnmente apodado «Jumbo», es un avión comercial transcontinental de fuselaje ancho fabricado por Boeing. Es conocido por su gran tamaño (fue el mayor avión de pasajeros durante más de cuatro décadas hasta que la compañía Airbus creó el A380)."));
         aviones.add(new Avion("Airbus A300","l Airbus A300 es un avión comercial de reacción, bimotor y de fuselaje ancho, desarrollado y fabricado por el consorcio europeo Airbus. Entre 1974 y julio de 2007 fueron fabricados un total de 843 A300. Basándose en el Airbus A300 se desarrolló un modelo con menor longitud y con mayor alcance."));
         aviones.add(new Avion("Airbus A330","El Airbus A330 es un avión comercial de reacción, bimotor y de fuselaje ancho, desarrollado por Airbus, un consorcio de compañías aeroespaciales europeas actualmente propiedad de la corporación europea Airbus Group. Las distintas versiones del A330 tienen un alcance que va desde los 7400 a los 13430 km y tiene capacidad para acomodar hasta 335 pasajeros en una configuración de dos clases, o en su lugar, transportar hasta 70 toneladas de carga."));
         aviones.add(new Avion("Boeing 787","El Boeing 787, apodado «Dreamliner», es un avión comercial de tamaño medio y fuselaje ancho desarrollado por el fabricante estadounidense Boeing Commercial Airplanes. La aeronave, de doble pasillo, puede transportar entre 217 y 323 pasajeros, dependiendo del tipo (787-8, -9 o -10). Su primer vuelo tuvo lugar el 19 de diciembre de 2009. "));
     }

    List<Avion> obtener() {
        return aviones;
    }

    void insertar(Avion avion, Callback callback){
        aviones.add(avion);
        callback.cuandoFinalice(aviones);
    }

    void eliminar(Avion avion, Callback callback) {
        aviones.remove(avion);
        callback.cuandoFinalice(aviones);
    }

    void actualizar(Avion avion, float valoracion, Callback callback) {
        avion.valoracion = valoracion;
        callback.cuandoFinalice(aviones);
    }
}
