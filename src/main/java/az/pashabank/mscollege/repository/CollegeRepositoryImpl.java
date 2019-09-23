package az.pashabank.mscollege.repository;


import az.pashabank.mscollege.dto.CollegeDto;
import az.pashabank.mscollege.model.CollegeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CollegeRepositoryImpl implements CollegeRepositroy {

    private static final String findAllCollegeSql = "select c.id as college_id, c.name, c.city   from college c ";
    private static final String findAllCollegeByIdSql =" select c.id as college_id, c.name, c.city   from college c   where  c.id = ?";
    private static final String addCollegeSql = "insert into college (id, name, city) values (?,?,?)";
    private static final String updateCollegeByIdSql = "update college  set name = ?, city = ? where id = ?";
    private static final String deleteCollegeSql = "delete from college  where id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CollegeDto> findAllCollege() {

        List<CollegeDto> collegeList =jdbcTemplate.query(findAllCollegeSql, new Object[]{}, new ResultSetExtractor<List<CollegeDto>>() {
            @Override
            public List<CollegeDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<CollegeDto> list = new LinkedList<>();

                while (rs.next()) {
                    CollegeDto collegeDto = new CollegeDto();
                    collegeDto.setId(rs.getLong("college_id"));
                    collegeDto.setName(rs.getString("name"));
                    collegeDto.setCity(rs.getString("city"));

                    list.add(collegeDto);
                }
                return list;
            }
        });
        return collegeList;
    }

    @Override
    public CollegeDto findCollegeById(Long collegeId) {

        CollegeDto collegeDto = jdbcTemplate.queryForObject(findAllCollegeByIdSql, new Object[]{collegeId}, new RowMapper<CollegeDto>() {
            @Override
            public CollegeDto mapRow(ResultSet rs, int i) throws SQLException {
                CollegeDto collegeDto1 = new CollegeDto();
                collegeDto1.setId(rs.getLong("college_id"));
                collegeDto1.setName(rs.getString("name"));
                collegeDto1.setCity(rs.getString("city"));

                return collegeDto1;
            }
        });
        return collegeDto;
    }

    @Override
    public void addCollege(CollegeModel c) {
    int affectedRows = jdbcTemplate.update(addCollegeSql, c.getId(), c.getName(), c.getCity());
    }

    @Override
    public void updateCollege(CollegeModel c) {
        int affectedRows = jdbcTemplate.update(updateCollegeByIdSql, c.getName(), c.getCity(),  c.getId());

    }

    @Override
    public void deleteCollegeById(Long collegeId) {
    int affectedRows = jdbcTemplate.update(deleteCollegeSql, collegeId);
    }
}
