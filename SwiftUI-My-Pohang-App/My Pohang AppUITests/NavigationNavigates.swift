//
//  NavigationNavigates.swift
//  My Pohang AppUITests
//
//  Created by Jaehwa Noh on 12/23/23.
//

import XCTest


func navigateRecommend(app: XCUIApplication) {
    let categoryCoffeeButton = app.buttons["카페"]
    categoryCoffeeButton.tap()
}

func navigateRecommendDetail(app: XCUIApplication) {
    navigateRecommend(app: app)
    let recommendButton = app.buttons["러블랑"]
    recommendButton.tap()
}

func openSidebarWithCount(app: XCUIApplication, count: Int) {
    let toggleSidebarButton = app.buttons["ToggleSidebar"]
    XCTAssertTrue(toggleSidebarButton.exists)
    toggleSidebarButton.tap(withNumberOfTaps: count, numberOfTouches: 1)
}
