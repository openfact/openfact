
    create table bajas (
       id varchar(255) not null,
        cdr_file_id varchar(255),
        enviar_cliente char(255) not null,
        enviar_sunat char(255) not null,
        estado varchar(255) not null,
        fecha_emision date not null,
        file_id varchar(255),
        motivo_baja varchar(255),
        numero integer not null,
        serie varchar(11) not null,
        invoice_id varchar(255) not null,
        nota_id varchar(255) not null,
        primary key (id)
    );

    create table cn_document (
       id varchar(36) not null,
        amount double,
        assigned_id varchar(255) not null,
        currency varchar(255),
        customer_assigned_id varchar(255),
        customer_name varchar(255),
        issue_date timestamp,
        supplier_assigned_id varchar(255) not null,
        supplier_name varchar(255) not null,
        tax double,
        type varchar(255) not null,
        primary key (id)
    );

    create table component (
       id varchar(36) not null,
        name varchar(255),
        parent_id varchar(255),
        provider_id varchar(255),
        provider_type varchar(255),
        sub_type varchar(255),
        organization_id varchar(255) not null,
        primary key (id)
    );

    create table component_config (
       id varchar(36) not null,
        name varchar(255),
        value varchar(4000),
        component_id varchar(36),
        primary key (id)
    );

    create table datos_venta (
       id varchar(255) not null,
        cliente_direccion varchar(255),
        cliente_email varchar(255),
        cliente_nombre varchar(255),
        cliente_numero_documento varchar(255),
        cliente_tipo_documento varchar(255),
        fecha_emision timestamp,
        fecha_vencimiento timestamp,
        igv decimal(19,2),
        isc decimal(19,2),
        moneda varchar(255),
        tipo_cambio decimal(19,2),
        observaciones varchar(255),
        total_descuento_global decimal(19,2),
        total_otros_cargos decimal(19,2),
        total_pagar decimal(19,2),
        total_exonerado decimal(19,2),
        total_gratuito decimal(19,2),
        total_gravado decimal(19,2),
        total_inafecto decimal(19,2),
        primary key (id)
    );

    create table datos_venta_detalle (
       id varchar(255) not null,
        cantidad decimal(13,3) not null,
        descripcion varchar(255) not null,
        precio_unitario decimal(12,2) not null,
        subtotal decimal(12,2) not null,
        tipo_igv varchar(255) not null,
        total decimal(12,2) not null,
        total_igv decimal(12,2) not null,
        total_isc decimal(12,2),
        unidad_medida varchar(255) not null,
        valor_unitario decimal(12,2) not null,
        datos_venta_id varchar(255) not null,
        primary key (id)
    );

    create table file (
       filename varchar(255) not null,
        file_bytes blob,
        primary key (filename)
    );

    create table invoice (
       id varchar(255) not null,
        cdr_file_id varchar(255),
        codigo_tipo_comprobante varchar(255) not null,
        created_at timestamp,
        enviar_cliente char(255) not null,
        enviar_sunat char(255) not null,
        estado varchar(255) not null,
        estado_descripcion varchar(255),
        file_id varchar(255),
        numero integer not null,
        serie varchar(4) not null,
        version integer,
        datos_venta_id varchar(255) not null,
        organization_id varchar(255) not null,
        resumen_diario_id varchar(255),
        nota_id varchar(255) not null,
        primary key (id)
    );

    create table memberships (
       id varchar(255) not null,
        created_on timestamp,
        version integer,
        organization_id varchar(255),
        role_id varchar(255),
        user_id varchar(255),
        primary key (id)
    );

    create table nota (
       id varchar(255) not null,
        cdr_file_id varchar(255),
        codigo_tipo_comprobante varchar(255) not null,
        created_at timestamp,
        enviar_cliente char(255) not null,
        enviar_sunat char(255) not null,
        estado varchar(255) not null,
        estado_descripcion varchar(255),
        file_id varchar(255),
        numero integer not null,
        serie varchar(4) not null,
        tipo_nota varchar(255) not null,
        version integer,
        datos_venta_id varchar(255) not null,
        invoice_afectado_id varchar(255) not null,
        organization_id varchar(255) not null,
        nota_id varchar(255) not null,
        primary key (id)
    );

    create table organizacion_informacion_adicional (
       additional_assigned_id varchar(255),
        assigned_id varchar(255),
        codigo_pais varchar(255),
        codigo_postal varchar(255),
        direccion varchar(255),
        distrito varchar(255),
        nombre_comercial varchar(255),
        provincia varchar(255),
        razon_social varchar(255),
        region varchar(255),
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table organizacion_informacion_sunat (
       boleta_factura_endpoint varchar(255),
        consulta_cdr_endpoint varchar(255),
        consulta_factura_endpoint varchar(255),
        guia_remision_enpoint varchar(255),
        password varchar(255),
        retencion_percepcion_endpoint varchar(255),
        use_custom_config char(255) not null,
        usuario varchar(255),
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table organization (
       id varchar(255) not null,
        description varchar(255),
        name varchar(255) not null,
        time_zone varchar(255) not null,
        type varchar(255) not null,
        use_custom_certificates char(255) not null,
        use_custom_smtp_config char(255) not null,
        version integer,
        primary key (id)
    );

    create table organization_smtp_config (
       organization_id varchar(255) not null,
        VALUE varchar(255),
        NAME varchar(255) not null,
        primary key (organization_id, NAME)
    );

    create table percepcion (
       id varchar(255) not null,
        primary key (id)
    );

    create table permissions (
       role_id varchar(255) not null,
        permissions integer
    );

    create table resumen_diario (
       id varchar(255) not null,
        enviar_sunat char(255) not null,
        organization_id varchar(255) not null,
        nota_id varchar(255) not null,
        primary key (id)
    );

    create table retencion (
       id varchar(255) not null,
        primary key (id)
    );

    create table roles (
       id varchar(255) not null,
        auto_grant boolean,
        created_on timestamp,
        description varchar(512),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id varchar(255) not null,
        email varchar(255),
        full_name varchar(255),
        identity_id varchar(255) not null,
        identity_provider varchar(255) not null,
        joined_on timestamp not null,
        username varchar(255) not null,
        version integer,
        primary key (id)
    );

    create table estadoSunat (
       id varchar(255) not null,
        codigo varchar(255),
        descripcion varchar(450),
        estado char(255) not null,
        primary key (id)
    );

    alter table cn_document
       add constraint UKawubnbop2ucyh7b4ty92y1u76 unique (type, assigned_id, supplier_assigned_id);

    alter table invoice
       add constraint UKp46ib7nymb41yq7we4w77tp0v unique (serie, numero, organization_id);

    alter table memberships
       add constraint UKidamvecwj5pj5timgjyy8pq79 unique (user_id, role_id, organization_id);

    alter table nota
       add constraint UKkmnt4sl01hg1ohnsqaj0wbu8k unique (serie, numero, organization_id);

    alter table organization
       add constraint UK8j5y8ipk73yx2joy9yr653c9t unique (name);

    alter table roles
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table users
       add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);

    alter table users
       add constraint UK19vywygog85fl7f6t9dstiga8 unique (identity_id);

    alter table bajas
       add constraint FK725fkaqvybfxwphu6l8a8mprv
       foreign key (invoice_id)
       references invoice;

    alter table bajas
       add constraint FKo35qdiq5hnnn329oxkgxylvsa
       foreign key (nota_id)
       references estadoSunat;

    alter table component
       add constraint FKmpfdha5eg9fm6ht2ue01ec9l6
       foreign key (organization_id)
       references organization;

    alter table component_config
       add constraint FK30o84r8uoxnh7wlbkw1a5mqje
       foreign key (component_id)
       references component;

    alter table datos_venta_detalle
       add constraint FK313noidta4kamscovgqyiagnu
       foreign key (datos_venta_id)
       references datos_venta;

    alter table invoice
       add constraint FK33s4xquf6gnruofxj03x8l6g8
       foreign key (datos_venta_id)
       references datos_venta;

    alter table invoice
       add constraint FK13c3hatm6ciotvxqc5mjlagdo
       foreign key (organization_id)
       references organization;

    alter table invoice
       add constraint FK3864q3ne48ba6ujr3kjchigsp
       foreign key (resumen_diario_id)
       references resumen_diario;

    alter table invoice
       add constraint FK9driov3gcc1wcxrsrv8roae9u
       foreign key (nota_id)
       references estadoSunat;

    alter table memberships
       add constraint FKp778ik4pdu8wu3hra61aw2ufg
       foreign key (organization_id)
       references organization;

    alter table memberships
       add constraint FKokckx6lcp3k4fwe6qqc621jsp
       foreign key (role_id)
       references roles;

    alter table memberships
       add constraint FKdjormybfoo7f4i4d4r803qohb
       foreign key (user_id)
       references users;

    alter table nota
       add constraint FK7mwj8xxwljvh55dqukydyb05b
       foreign key (datos_venta_id)
       references datos_venta;

    alter table nota
       add constraint FKqlqgj5sq8d4m7obug3fo9m575
       foreign key (invoice_afectado_id)
       references invoice;

    alter table nota
       add constraint FKf1ekqe99hns4j7og79dq92d4
       foreign key (organization_id)
       references organization;

    alter table nota
       add constraint FKpex5uh3lth6pahdok9hvco46l
       foreign key (nota_id)
       references estadoSunat;

    alter table organizacion_informacion_adicional
       add constraint FKbweggho1n7o8l6wjfsc1j2y3i
       foreign key (organizacion_id)
       references organization;

    alter table organizacion_informacion_sunat
       add constraint FKrsoiphgv2e9ow9d0idp6wpt1c
       foreign key (organizacion_id)
       references organization;

    alter table organization_smtp_config
       add constraint FK3mxpb3h5ubslswet02l5uf04m
       foreign key (organization_id)
       references organization;

    alter table permissions
       add constraint FKmvliun0ngpho0bltt7j6ycqgc
       foreign key (role_id)
       references roles;

    alter table resumen_diario
       add constraint FKm5kc9vq46gh2yo473nnyjxi9j
       foreign key (organization_id)
       references organization;

    alter table resumen_diario
       add constraint FKrpcdr9ekhxmifmpetks8a1c4q
       foreign key (nota_id)
       references estadoSunat;
