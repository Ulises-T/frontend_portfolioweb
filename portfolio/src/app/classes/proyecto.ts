export class Proyecto {
    id?:number;
    nombreProyecto: string;
    descripcionProyecto: string;
    imgProyecto:string;
    urlProyecto:string;


    constructor( nombreProyecto:string, descripcionProyecto:string, imgProyecto:string, urlProyecto:string){
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imgProyecto = imgProyecto;
        this.urlProyecto = urlProyecto;
    }

}
