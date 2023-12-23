//
//  ContentView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct MyPohangApp: View {
    var body: some View {
        NavigationSplitView {
            CategoryView()
        } content: {
            EmptyView()
        } detail: {
            EmptyView()
        }
        .navigationSplitViewStyle(.balanced)
    }
}

#Preview {
    MyPohangApp()
}
