package javaGuides.duc.Entity;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String comment;
	@Column
	private String name;
	@Column
	private Instant date;
	@Column
	private Instant time_create;
	@Column
	private Instant time_update;
	@Column 
	private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Instant getTime_create() {
		return time_create;
	}

	public void setTime_create(Instant time_create) {
		this.time_create = time_create;
	}

	public Instant getTime_update() {
		return time_update;
	}

	public void setTime_update(Instant time_update) {
		this.time_update = time_update;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "menu_food", joinColumns = {
			@JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false) })
	private Set<Food> foods;
	@ManyToMany(mappedBy = "menus")
	private Set<ClassRoom> classRooms;

	public Set<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(Set<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}
}
