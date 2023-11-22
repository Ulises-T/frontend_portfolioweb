export class Estudios {
    id?:number;
    nombreEst: string;
    fechaEst:string
    descripcionEst: string;
    
    constructor(nombreEst: string,  fechaEst: string, descripcionEst: string){
        this.nombreEst = nombreEst;
        this.fechaEst = fechaEst;
        this.descripcionEst = descripcionEst;
    }

}