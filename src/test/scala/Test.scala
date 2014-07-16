import org.json4s.{DefaultFormats, Extraction}
import org.scalatest.FunSpec
import spire.math.{FixedScale, Rational}

case class RationalValue(value:Rational)

class Test extends FunSpec {
  describe("with Big Decimal") {
    describe ("when doing it explicity") {
      describe ("with Rational Numbers") {
        it("should equal itself") {
          val fixedScale = FixedScale(10)
          val formats = DefaultFormats.withBigDecimal ++ org.json4s.spire.Serializers.withDecimal(fixedScale)
          val json = Extraction.decompose(Map(
            "value" -> BigDecimal("2332.32")
          ))(formats)
          val m = manifest[RationalValue]
          val extracted:RationalValue = Extraction.extract(json)(formats,m)
          assert(Rational("2332.32") == extracted.value)
        }
      }
    }
    describe ("when doing it implicitly") {
      it ("should equal itself") {
        implicit val fixedScale = FixedScale(10)
        implicit val formats = DefaultFormats.withBigDecimal ++ org.json4s.spire.Serializers.withDecimal(fixedScale)
        val json = Extraction.decompose(Map(
          "value" -> BigDecimal("2332.32")
        ))
        implicit val m = manifest[RationalValue]
        val extracted:RationalValue = Extraction.extract(json)
        assert(Rational("2332.32") == extracted.value)
      }
    }
  }



}
