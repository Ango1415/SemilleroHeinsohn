export class ComicDTO{

    public id: number;

    public nombre : string;

    public editorial : string;

    public tematicaEnum : string;

    public coleccion : string;

    public numeroPaginas : number;
    
    public precio : number;

    public autores : string;

    public color : boolean;

    //public fecha : Date;

    constructor (){
        //Constructor vacio de la clase
    }

    /* public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    } */

}