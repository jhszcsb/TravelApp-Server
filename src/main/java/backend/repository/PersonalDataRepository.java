package backend.repository;

import backend.entity.PersonalData;

public interface PersonalDataRepository extends BaseRepository<PersonalData, Integer> {

    PersonalData findByUsername(String username);
}
