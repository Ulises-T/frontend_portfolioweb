export class Estudios {
    id?:number;
    nombreEstudio: string;
    institucion: string;
    fechaInicio:string
    fechaFin: string
    
    constructor(nombreEstudio: string,  institucion: string, fechaInicio: string, fechaFin: string ){
        this.nombreEstudio = nombreEstudio;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

}