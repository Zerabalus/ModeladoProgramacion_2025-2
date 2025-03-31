import unittest
import os

if __name__ == "__main__":
    
    test_dir = os.path.join(os.path.dirname(__file__), "tests")
    
    loader = unittest.TestLoader()
    suite = loader.discover(test_dir, pattern="test_*.py")
    
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)