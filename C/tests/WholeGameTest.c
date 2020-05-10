#include <setjmp.h> /* used by cmocka */
#include <stdarg.h> /* used by cmocka */
#include <stddef.h> /* used by cmocka */

#include "../game_runner.c"
#include "capture_std_out.c"
#include <approvals_cmocka.h>
#include <cmocka.h>

#define NUM_TESTS 25

static void
test_plays_trivia (void **state)
{
  (void)state; /* unused */

  for (unsigned int i = 0; i < NUM_TESTS; i++)
  {
    unsigned int seed = 147621 + 13 * i;
    run (seed);
  }

  verify_txt (get_std_out (), "test_plays_trivia");
}

int
main (void)
{
  const struct CMUnitTest test_suite[] = {
      cmocka_unit_test_setup_teardown (test_plays_trivia, capture_std_out, reset_std_out), /* */
  };

  return cmocka_run_group_tests (test_suite, NULL, NULL);
}
