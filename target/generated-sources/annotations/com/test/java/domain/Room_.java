package com.test.java.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Room.class)
public abstract class Room_ {

	public static volatile SingularAttribute<Room, String> name;
	public static volatile SingularAttribute<Room, Long> id;
	public static volatile SingularAttribute<Room, String> countryName;
	public static volatile SingularAttribute<Room, String> lightStatus;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String COUNTRY_NAME = "countryName";
	public static final String LIGHT_STATUS = "lightStatus";

}

