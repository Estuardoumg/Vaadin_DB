package com.example.demo.visual;


import com.example.demo.domain.Propietario;
import com.example.demo.domain.PropietarioRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by PC on 15/07/2017.
 */
@SpringUI
public class App extends UI{

    @Autowired
    PropietarioRepository propietarioRepository;

    protected void init (VaadinRequest vaadinRequest){
        VerticalLayout layout=new VerticalLayout(  );
        HorizontalLayout hlayout=new HorizontalLayout(  );
        Grid<Propietario> grid=new Grid<>();

        TextField cantidad=new TextField( "Cantidad" );
        TextField nombre=new TextField( "Nombre" );
        TextField edad=new TextField( "Edad" );
        TextField sexo=new TextField( "Sexo" );

        Button del=new Button( "Eliminar" );
        del.addClickListener( new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Notification.show( "por ahora no puede eliminar jajajaja" );
            }
        } );


        Button add=new Button( "Adicionar" );
        add.addClickListener( new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Propietario e=new Propietario( );

                e.setCantidad(cantidad.getValue());
                e.setNombre(nombre.getValue());
                e.setEdad(edad.getValue());
                e.setSexo(sexo.getValue());

                propietarioRepository.save( e );
                grid.setItems( propietarioRepository.findAll() );

                cantidad.clear();
                nombre.clear();
                edad.clear();
                sexo.clear();

                Notification.show( "Propietario adicionado" );

            }
        } );

        hlayout.addComponents(cantidad,nombre, edad,sexo,add,del  );
        hlayout.setComponentAlignment(add, Alignment.BOTTOM_RIGHT  );
        hlayout.setComponentAlignment(del, Alignment.BOTTOM_LEFT  );


        grid.addColumn ( Propietario::getId).setCaption("Id");
        grid.addColumn ( Propietario::getCantidad).setCaption("Cantidad");
        grid.addColumn ( Propietario::getNombre).setCaption("Nombre");
        grid.addColumn ( Propietario::getEdad).setCaption("Edad");
        grid.addColumn ( Propietario::getSexo).setCaption("Sexo");

        layout.addComponents( hlayout);
        layout.addComponents(grid);

        setContent( layout );
    }


}
