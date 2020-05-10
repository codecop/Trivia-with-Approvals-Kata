#include <stdio.h>  /* printf  */
#include <string.h> /* memset  */

static FILE __original;
static char *__fileName;
static FILE *__captured;
static long __startPos;

#define READ_BUFFER 100000
static char __readBuffer[READ_BUFFER];

static int
capture_std_out (void **state)
{
  (void)state; /* unused */

  __original = *stdout;
  __fileName = tmpnam (NULL);
  __captured = freopen (__fileName, "wb+", stdout);
  __startPos = 0;

  return 0;
}

static const char *
get_std_out (void)
{
  fflush (__captured);

  long next = ftell (__captured);
  fseek (__captured, __startPos, SEEK_SET);
  /* fprintf(stderr, "current startpos %d\n", __startPos); */

  memset (__readBuffer, 0, READ_BUFFER);
  fread (__readBuffer, sizeof (char), READ_BUFFER, __captured);
  /* fprintf(stderr, "read %s\n", __readBuffer); */

  __startPos = next;
  fseek (__captured, __startPos, SEEK_SET);
  /* fprintf(stderr, "next startpos %d\n", __startPos); */

  return __readBuffer;
}

static int
reset_std_out (void **state)
{
  (void)state; /* unused */

  fclose (__captured);
  remove (__fileName);

  return 0;
}
