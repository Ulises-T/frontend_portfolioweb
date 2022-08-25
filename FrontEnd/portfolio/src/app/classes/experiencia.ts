export class Experiencia {
    id? : number;
    nombreExp : string;
    descripcionExp : string;
    imgExp : string;
    fechaExp : string;

    constructor(nombreExp:string, descripcionExp:string, imgExp:string,fechaExp:string){
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.fechaExp = fechaExp;
        this.imgExp = imgExp;
    }
}
