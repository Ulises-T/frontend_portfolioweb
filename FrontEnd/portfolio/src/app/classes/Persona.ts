export class Persona {
    id?:number;
    nombre: String;
    apellido: String;
    titulo:String;
    img:String;


    constructor(nombre:String, apellido:String, titulo:String, img:String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.img = img;
    }

}

