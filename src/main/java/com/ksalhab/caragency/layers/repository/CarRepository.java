package com.ksalhab.caragency.layers.repository;

import com.ksalhab.caragency.layers.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class CarRepository {

	private final JdbcTemplate jdbcTemplate;
	private RowMapper<Car> rowMapper;

	public Car getCar(Long id) {
		try {
			return jdbcTemplate.queryForObject("select * from cars " +
					                                   "where id=?", rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Car> getAllCars() {
		return jdbcTemplate.query("select * from cars", rowMapper);
	}

	public Car addCar(Car car) {
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement(
					"INSERT INTO public.cars(\n" +
							"\tyear, model, horse_power, electric, used, number_of_seats)\n" +
							"\tVALUES (?, ?, ?, ?, ?, ?)", new String[]{"id"});

			carStatementParsing(car, preparedStatement);

			return preparedStatement;
		}, keyHolder);

		long generatedKey = Objects.requireNonNull(keyHolder.getKey()).longValue();
		return getCar(generatedKey);
	}

	public Car updateCar(Long id, Car car) {
		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement(
					"UPDATE public.cars " +
							"SET year=?, model=?, horse_power=?, electric=?, used=?, number_of_seats=? " +
							"WHERE id=?;");

			carStatementParsing(car, preparedStatement);
			preparedStatement.setLong(7, id);
			return preparedStatement;
		});
		return getCar(id);
	}

	public void deleteCar(Long id) {
		jdbcTemplate.update("DELETE FROM cars where id=?", id);
	}

	private void carStatementParsing(Car car, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, car.getYear());
		preparedStatement.setString(2, car.getModel());
		preparedStatement.setInt(3, car.getHorsePower());
		preparedStatement.setBoolean(4, car.getUsed());
		preparedStatement.setBoolean(5, car.getUsed());
		preparedStatement.setInt(6, car.getNumberOfSeats());
	}

}
