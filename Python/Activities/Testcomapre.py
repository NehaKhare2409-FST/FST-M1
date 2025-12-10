import pytest

@pytest.mark.great
def test_greater():
    assert 5>2

@pytest.mark.great
def test_greater_euqla():
    assert 6>=6

@pytest.mark.great
def test_lesser():
    assert 2<5