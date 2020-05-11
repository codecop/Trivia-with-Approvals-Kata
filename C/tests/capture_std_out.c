#include <stdio.h> /* printf  */

static char *__fileName;
static FILE *__captured;
static long __startPos;

#define BUFFER_SIZE 100000
static char __readBuffer[BUFFER_SIZE];

#define DEBUG 0

static int
capture_std_out (void **state)
{
  (void)state; /* unused */

  __fileName = tmpnam (NULL);
  __captured = freopen (__fileName, "w+", stdout);
  __startPos = 0;

  return 0;
}

static const char *
get_std_out (void)
{
  int error_flush = fflush (__captured);
  if (error_flush)
  {
    fprintf (stderr, "Could not flush %s, error %d.\n", __fileName, error_flush);
  }

  long next = ftell (__captured);
  int error_seek = fseek (__captured, __startPos, SEEK_SET);
  if (error_seek)
  {
    fprintf (stderr, "Could not seek file %s, error %d.\n", __fileName, error_seek);
  }
  if (DEBUG)
  {
    fprintf (stderr, "debug: file %s, current startpos %ld\n", __fileName, __startPos);
  }

  size_t read = fread (__readBuffer, sizeof (char), BUFFER_SIZE, __captured);
  __readBuffer[read] = '\0';
  if (read == 0)
  {
    fprintf (stderr, "Did not read file %s, got %lu bytes.\n", __fileName, read);
  }
  if (DEBUG)
  {
    fprintf (stderr, "debug: file %s, read %s\n", __fileName, __readBuffer);
  }

  __startPos = next;
  error_seek = fseek (__captured, __startPos, SEEK_SET);
  if (error_seek)
  {
    fprintf (stderr, "Could not seek file %s, error %d.\n", __fileName, error_seek);
  }
  if (DEBUG)
  {
    fprintf (stderr, "debug: file %s, next startpos %ld\n", __fileName, __startPos);
  }

  return __readBuffer;
}

static int
reset_std_out (void **state)
{
  (void)state; /* unused */

  int error_close = fclose (__captured);
  if (error_close)
  {
    fprintf (stderr, "Could not close %s, error %d.\n", __fileName, error_close);
  }
  int error_remove = remove (__fileName);
  if (error_remove)
  {
    fprintf (stderr, "Could not remove %s, error %d.\n", __fileName, error_remove);
  }

  return 0;
}
