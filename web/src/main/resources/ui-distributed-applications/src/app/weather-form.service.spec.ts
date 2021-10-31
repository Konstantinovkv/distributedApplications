import { TestBed } from '@angular/core/testing';

import { WeatherFormService } from './weather-form.service';

describe('WeatherFormService', () => {
  let service: WeatherFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeatherFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
