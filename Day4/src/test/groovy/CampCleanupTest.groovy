import com.small.advent2022.CampCleanup
import spock.lang.Specification

class CampCleanupTest extends Specification {
    CampCleanup campCleanup
    void setup() {
        campCleanup = new CampCleanup()
    }

    def "is contained "() {
        expect:
        campCleanup.isContained("2-4,6-8") == false
        campCleanup.isContained("2-3,4-5") == false
        campCleanup.isContained("5-7,7-9") == false
        campCleanup.isContained("2-8,3-7") == true
        campCleanup.isContained("6-6,4-6") == true
        campCleanup.isContained("2-6,4-8") == false
    }
    def "count contained"() {
        List<String> list = List.of(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8"
        )
        expect:
        campCleanup.countContained(list) == 2
    }
    def "is overLapped "() {
        expect:
        campCleanup.isOverLapped("2-4,6-8") == false
        campCleanup.isOverLapped("2-3,4-5") == false
        campCleanup.isOverLapped("5-7,7-9") == true
        campCleanup.isOverLapped("2-8,3-7") == true
        campCleanup.isOverLapped("6-6,4-6") == true
        campCleanup.isOverLapped("2-6,4-8") == true
    }
    def "count overlapped"() {
        List<String> list = List.of(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8"
        )
        expect:
        campCleanup.countOverlapped(list) == 4
    }
}
