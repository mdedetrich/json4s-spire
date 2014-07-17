package org.json4s.spire

import org.json4s.CustomSerializer
import org.json4s.JsonAST._
import spire.math._

object Serializers {
  private final class RationalSerializerDecimal extends CustomSerializer[Rational](format => (
    {case JDecimal(x) => Rational(x)},
    {case x:Rational => JDecimal(x.toBigDecimal)}
  ))

  private final class RationalSerializerDouble extends CustomSerializer[Rational](format => (
    {case JDecimal(x) => Rational(x)},
    {case x:Rational => JDouble(x.toDouble)}
  ))

  private final class NaturalSerializer extends CustomSerializer[Natural](format => (
    {case JInt(x) => Natural(x)},
    {case x:Natural => JInt(x.toBigInt)}
  ))

  private final class AlgebraicSerializerDecimal extends CustomSerializer[Algebraic](format => (
    {case JDecimal(x) => Algebraic(x)},
    {case x:Algebraic => JDecimal(x.toBigDecimal)}
  ))

  private final class AlgebraicSerializerDouble extends CustomSerializer[Algebraic](format => (
    {case JDouble(x) => Algebraic(x)},
    {case x:Algebraic => JDouble(x.toDouble)}
  ))

  private final class SafeLongSerializer extends CustomSerializer[SafeLong](format => (
    {case JInt(x) => SafeLong(x)},
    {case x:SafeLong => JInt(x.toBigInt)}
  ))

  private final class FixedPointSerializerDecimal(implicit fixedScale:FixedScale) extends CustomSerializer[FixedPoint](format =>(
    {case JDecimal(x) => FixedPoint(x)},
    {case x:FixedPoint => JDecimal(x.toBigDecimal)}
  ))

  private final class FixedPointSerializerDouble(implicit fixedScale:FixedScale) extends CustomSerializer[FixedPoint](format =>(
    {case JDouble(x) => FixedPoint(x)},
    {case x:FixedPoint => JDouble(x.toDouble)}
  ))

  private final class NumberSerializerDecimal extends CustomSerializer[Number](format => (
    {case JDouble(x) => Number(x)},
    {case x:Number => JDecimal(x.toBigDecimal)}
  ))

  private final class NumberSerializerDouble extends CustomSerializer[Number](format => (
    {case JDecimal(x) => Number(x)},
    {case x:Number => JDecimal(x.toDouble)}
  ))

  def withDecimal(implicit fixedScale:FixedScale) = Seq(
    new RationalSerializerDecimal,
    new NaturalSerializer,
    new AlgebraicSerializerDecimal,
    new SafeLongSerializer,
    new FixedPointSerializerDecimal,
    new NumberSerializerDecimal
  )

  def withDouble(implicit fixedScale:FixedScale) = Seq(
    new RationalSerializerDouble,
    new NaturalSerializer,
    new AlgebraicSerializerDouble,
    new SafeLongSerializer,
    new FixedPointSerializerDouble,
    new NumberSerializerDouble
  )

}
