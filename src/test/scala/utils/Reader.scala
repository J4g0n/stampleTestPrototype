package utils


case class Reader[Conf, T](read: Conf => T) { self =>

  def map[U](convert: T => U): Reader[Conf, U] =
    Reader(self.read andThen convert)

  def flatMap[V](toReader: T => Reader[Conf, V]): Reader[Conf, V] =
    Reader[Conf, V](conf => toReader(self.read(conf)).read(conf))

  def local[BiggerConf](extractFrom: BiggerConf => Conf): Reader[BiggerConf, T] =
    Reader[BiggerConf, T](extractFrom andThen self.read)
}

object Reader {
  def pure[C, A](a: A): Reader[C, A] =
    Reader(_ => a)

  implicit def funToReader[Conf, A](read: Conf => A): Reader[Conf, A] =
    Reader(read)
}
