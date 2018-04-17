package taskly.system.section

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import taskly.system.report.Location
import taskly.system.specification.AllCriticalSectionsInSectorOf
import taskly.system.specification.SectorCriteria


@Service
class CriticalSectionService {

    @Autowired
    private lateinit var criticalSectionRepository: CriticalSectionRepository

    fun findAllCriticalSectionsNear(location: Location, byDistance: Double): List<CriticalSection> =
            criticalSectionRepository.findAll(AllCriticalSectionsInSectorOf(SectorCriteria(
                    origin = location, radiusOfSector = byDistance, keyAttributeLocation = "origin")))
                    .filter { it.origin.distanceFrom(location) < byDistance }

    fun findAt(location: Location, byDistance: Double): CriticalSection? =
            findAllCriticalSectionsNear(location, byDistance).firstOrNull()

    fun save(criticalSection: CriticalSection): CriticalSection =
            criticalSectionRepository.save(criticalSection.copy(id = 0))

    fun delete(id: Int): CriticalSection? = criticalSectionRepository
            .findById(id)?.also { criticalSectionRepository.delete(it) }

    fun getById(id: Int): CriticalSection? = criticalSectionRepository.findById(id)

}