package org.jortiz.springcloud.msvc.usuarios.models.entity;


import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    //GenerationType.IDENTITY ==> genera automáticamente una llave primaria de forma incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column() ==> podemos añadir el column para ser más especificos en la columna de la BBDD por ejemplo le podemos decir que no sea null, o indicar el nombre de la columna si no es igual
    private String nombre;
    //unique = true ==> es para indicar que el campo mail es único
    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}
