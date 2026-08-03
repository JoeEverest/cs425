package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "classroom")
public class Classroom {

	@Id
	@Column(name = "classroom_id")
	private Long classroomId;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "room_number")
	private String roomNumber;

	public Classroom() {
	}

	public Classroom(Long classroomId, String buildingName, String roomNumber) {
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return String.format(
				"Classroom{classroomId=%d, buildingName=%s, roomNumber=%s}",
				classroomId, buildingName, roomNumber);
	}
}
