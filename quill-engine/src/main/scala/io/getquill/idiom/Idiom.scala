package io.getquill.idiom

import io.getquill.ast._
import io.getquill.NamingStrategy
import io.getquill.IdiomContext
import io.getquill.context.{ ExecutionType, IdiomReturningCapability }
import io.getquill.quat.Quat

trait Idiom extends IdiomReturningCapability {

  def emptySetContainsToken(field: Token): Token = StringToken("FALSE")

  def defaultAutoGeneratedToken(field: Token): Token = StringToken("DEFAULT VALUES")

  def liftingPlaceholder(index: Int): String

  def translate(ast: Ast, topLevelQuat: Quat, executionType: ExecutionType, transpileConfig: IdiomContext)(implicit naming: NamingStrategy): (Ast, Statement, ExecutionType)

  def translateCached(ast: Ast, topLevelQuat: Quat, executionType: ExecutionType, transpileConfig: IdiomContext)(implicit naming: NamingStrategy): (Ast, Statement, ExecutionType)

  def format(queryString: String): String = queryString

  def prepareForProbing(string: String): String
}
