export class Contacteme {
    id?:number;
    tipoContacto: string;
    direccionContacto:string;
    
    constructor(tipoContacto: string,  direccionContacto: string){
        this.tipoContacto = tipoContacto;
        this.direccionContacto = direccionContacto;
    }

}
