export class Persona {
    id?:number;
    nombre: String;
    apellido: String;
    titulo:String;


    constructor(nombre:String, apellido:String, titulo:String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
    }

}

